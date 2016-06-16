package menta.reasoneradapter

import impl.ReasonerAdapterImpl
import loophowto.LoopHowToTest
import org.slf4j.{LoggerFactory, Logger}
import org.junit.Test
import menta.model.Constant
import menta.model.howto.Solution
import menta.model.solutiongenerator.solutionchecker.Rule

/**
 * User: toschev alex
 * Date: 24.10.11
 * Time: 19:49
 */

@Test
class MainClassTest {
  val log: Logger = LoggerFactory.getLogger(this.getClass)

  val lph = new LoopHowToTest

  @Test
  def testOk() {
    assert(true)
  }

  // @Test
  def TestWithLoopHowTo() {
    val adapter = new ReasonerAdapterImpl
    var rqst = new menta.model.solutiongenerator.solutionchecker.Test
    rqst.solution = new Solution(lph.createSolution())

    rqst.rule = new Rule(lph.createAcceptanceCriteria.addIndividual())
    rqst.scope = Constant.modelNamespace

    val res = adapter(rqst)
    log.info("res {}", res)
    assert(res != null)
    assert(res.frequency == 1.0)
    assert(res.confidence >= 0.9)
    assert(!res.negation)
  }
}