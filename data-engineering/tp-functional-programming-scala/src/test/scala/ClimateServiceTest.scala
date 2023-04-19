import com.github.polomarcus.utils.ClimateService
import com.github.polomarcus.model.CO2Record
import org.scalatest.funsuite.AnyFunSuite
import ClimateService.filterDecemberData
import ClimateService.getMinMax
import ClimateService.getMinMaxByYear

//@See https://www.scalatest.org/scaladoc/3.1.2/org/scalatest/funsuite/AnyFunSuite.html
class ClimateServiceTest extends AnyFunSuite {
  test("containsWordGlobalWarming - non climate related words should return false") {
    assert( ClimateService.isClimateRelated("pizza") == false)
  }

  test("isClimateRelated - climate related words should return true") {
    assert(ClimateService.isClimateRelated("climate change") == true)
    assert(ClimateService.isClimateRelated("IPCC"))
    assert(ClimateService.isClimateRelated("global warming"))
  }

  //@TODO
  test("parseRawData") {
    // our inputs
    val firstRecord = (2003, 1, 355.2)     //help: to acces 2003 of this tuple, you can do firstRecord._1
    val secondRecord = (2004, 1, 375.2)
    val thirdRecord = (2004, 3, -485.2)
    val list1 = List(firstRecord, secondRecord)
    val list2 = List(firstRecord, thirdRecord)

    // our output of our method "parseRawData"
    val co2RecordWithType = CO2Record(firstRecord._1, firstRecord._2, firstRecord._3)
    val co2RecordWithType2 = CO2Record(secondRecord._1, secondRecord._2, secondRecord._3)

    val output = List(Some(co2RecordWithType), Some(co2RecordWithType2))
    val output2 = List(Some(co2RecordWithType), None)

    // we call our function here to test our input and output
    assert(ClimateService.parseRawData(list1) == output)
    assert(ClimateService.parseRawData(list2) == output2)
  }

  test("filterDecemberData") {
    val input = List(Some(CO2Record(2023, 12, 400)),
      Some(CO2Record(2023, 11, 390)),
      None,
      Some(CO2Record(2022, 12, 410)))
    val expectedOutput = List(CO2Record(2023, 11, 390))
    val actualOutput = filterDecemberData(input)
    assert(actualOutput == expectedOutput)
  }

  test("getMinMax should return the minimum and maximum ppm values in the list") {
    val input = List(
      CO2Record(2022, 1, 400),
      CO2Record(2022, 2, 410),
      CO2Record(2022, 3, 390),
      CO2Record(2022, 4, 420)
    )
    val expectedOutput = (390.0, 420.0)
    val actualOutput = getMinMax(input)
    assert(actualOutput == expectedOutput)
  }

  test("getMinMaxByYear should return the minimum and maximum ppm values for a given year") {
    val input = List(
      CO2Record(2022, 1, 400),
      CO2Record(2022, 2, 410),
      CO2Record(2022, 3, 390),
      CO2Record(2023, 1, 420),
      CO2Record(2023, 2, 430),
      CO2Record(2023, 3, 410)
    )
    val year = 2023
    val expectedOutput = (410.0, 430.0)
    val actualOutput = getMinMaxByYear(input, year)
    assert(actualOutput == expectedOutput)
  }
}
