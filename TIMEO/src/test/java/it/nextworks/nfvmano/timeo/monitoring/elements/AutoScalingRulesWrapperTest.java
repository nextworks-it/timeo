package it.nextworks.nfvmano.timeo.monitoring.elements;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.libs.common.enums.NsScaleType;
import it.nextworks.nfvmano.libs.descriptors.nsd.AutoscalingAction;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsAutoscalingRule;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marco Capitani on 20/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class AutoScalingRulesWrapperTest {

    private AutoScalingRulesWrapper wrapper;

    @Before
    public void setup() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = AutoScalingRulesWrapperTest.class.getClassLoader()
                .getResource("wrappertestrules.json")
                .openStream();
        List<NsAutoscalingRule> rules = mapper.readValue(inputStream, new TypeReference<List<NsAutoscalingRule>>() {});
        wrapper = new AutoScalingRulesWrapper(rules);
    }

    @Test
    public void emptyRules() {
        wrapper = new AutoScalingRulesWrapper(Collections.emptyList());
    }

    @Test
    public void testSimple() {
        List<AutoscalingAction> actions = wrapper.fireCriterion("s-cr");
        assertEquals(1, actions.size());
        AutoscalingAction action = actions.get(0);
        assertEquals(NsScaleType.SCALE_NS, action.getScaleType());
        assertEquals("il_vCDN_big", action.getScaleNsToLevelData().getNsInstantiationLevel());
    }

    @Test
    public void testBackoff() throws Exception {
        List<AutoscalingAction> actions = wrapper.fireCriterion("s-cr");
        assertEquals(1, actions.size());
        wrapper.stopFiring("s-cr");
        List<AutoscalingAction> actions2 = wrapper.fireCriterion("s-cr");
        assertEquals(0, actions2.size());
        wrapper.stopFiring("s-cr");
        Thread.sleep(1000);
        List<AutoscalingAction> actions3 = wrapper.fireCriterion("s-cr");
        assertEquals(1, actions3.size());
        assertEquals(actions, actions3);
    }

    @Test
    public void testDefault() {
        List<AutoscalingAction> actions = wrapper.fireCriterion("def-cr1");
        assertEquals(new ArrayList<>(), actions);
        List<AutoscalingAction> actions2 = wrapper.fireCriterion("def-cr2");
        assertEquals(1, actions2.size());
        AutoscalingAction action = actions2.get(0);
        assertEquals(NsScaleType.SCALE_NS, action.getScaleType());
        assertEquals("il_vCDN_big", action.getScaleNsToLevelData().getNsInstantiationLevel());
    }

    @Test
    public void testDefaultStopping() {
        List<AutoscalingAction> actions = wrapper.fireCriterion("def-cr1");
        assertEquals(new ArrayList<>(), actions);
        wrapper.stopFiring("def-cr1");
        List<AutoscalingAction> actions2 = wrapper.fireCriterion("def-cr2");
        assertEquals(new ArrayList<>(), actions2);
    }

    @Test
    public void testAnd() {
        List<AutoscalingAction> actions = wrapper.fireCriterion("and-cr1");
        assertEquals(new ArrayList<>(), actions);
        List<AutoscalingAction> actions2 = wrapper.fireCriterion("and-cr2");
        assertEquals(2, actions2.size());
        AutoscalingAction action = actions2.get(0);
        assertEquals(NsScaleType.SCALE_NS, action.getScaleType());
        assertEquals("il_vCDN_big", action.getScaleNsToLevelData().getNsInstantiationLevel());
        AutoscalingAction action2 = actions2.get(1);
        assertEquals(NsScaleType.SCALE_NS, action2.getScaleType());
        assertEquals("il_vCDN_big2", action2.getScaleNsToLevelData().getNsInstantiationLevel());
    }

    @Test
    public void testAndStopping() {
        List<AutoscalingAction> actions = wrapper.fireCriterion("and-cr1");
        assertEquals(new ArrayList<>(), actions);
        wrapper.stopFiring("and-cr1");
        List<AutoscalingAction> actions2 = wrapper.fireCriterion("and-cr2");
        assertEquals(new ArrayList<>(), actions2);
    }

    @Test
    public void testOr() throws Exception {
        List<AutoscalingAction> actions = wrapper.fireCriterion("or-cr1");
        assertEquals(1, actions.size());
        wrapper.stopFiring("or-cr1");
        Thread.sleep(1000);
        List<AutoscalingAction> actions2 = wrapper.fireCriterion("or-cr2");
        assertEquals(1, actions2.size());
    }
}