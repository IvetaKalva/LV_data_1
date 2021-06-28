import scala.xml.XML

object ETL_data extends App {
  val relativePath = "./src/resources/xml/LV_meta_UTF-8.xml"
  val xmlFile = XML.loadFile(relativePath)

// Just trying to get information to understand how it works

//  val country = (xmlFile \\ "country_name") .text
//  println(country)
//  println()

//  val stationID = xmlFile \\ "station"
//  stationID.foreach(el => println(el.attribute("Id"))).toString
//  println()
//
//  val Year = xmlFile \\ "statistics"
//  Year.foreach(el => println(el.attribute("Year"))).toString
//  println()
//
//  val value = xmlFile \\ "data_type"
//  value.foreach(el => println(el.attribute("value"))).toString
//  println()
//
//  val setType = xmlFile \\ "statistic_set"
//  setType.foreach(el => println(el.attribute("type"))).toString
//  println()
//
//  val component = xmlFile \\ "measurement_configuration"
//  component.foreach(el => println(el.attribute("component"))).toString
//  println()

  val childXML = xmlFile \\ "station_info"
//  println(childXML.text)

  case class StationInfo (station_european_code: String, station_local_code: String, station_name: String,
    station_description: String, station_nuts_level0: String, station_nuts_level1: Int, station_nuts_level2: Int,
    station_nuts_level3: Int, lau_level1_code: Int, lau_level2_code: Int, lau_level2_name: String, sabe_country_code: String,
    sabe_unit_code: Int, sabe_unit_name: String, station_start_date: String, station_latitude_decimal_degrees: Float,
                          station_longitude_decimal_degrees: Float, station_latitude_dms: String, station_longitude_dms: String,
                          station_altitude: Int, type_of_station: String, station_type_of_area: String, station_characteristic_of_zone: String,
                          station_subcategory_rural_background: String, monitoring_obj: String, meteorological_parameter: String)

  def fromXML(node: scala.xml.Node) :StationInfo = {
    StationInfo (
      (node \ "station_european_code").text,
      (node \ "station_local_code").text,
      (node \ "station_name").text,
      (node \ "station_description").text,
      (node \ "station_nuts_level0").text,
      (node \ "station_nuts_level1").text.toInt,
      (node \ "station_nuts_level2").text.toInt,
      (node \ "station_nuts_level3").text.toInt,
      (node \ "lau_level1_code").text.toInt,
      (node \ "lau_level2_code").text.toInt,
      (node \ "lau_level2_name").text,
      (node \ "sabe_country_code").text,
      (node \ "sabe_unit_code").text.toInt,
      (node \ "sabe_unit_name").text,
      (node \ "station_start_date").text,
      (node \ "station_latitude_decimal_degrees").text.toFloat,
      (node \ "station_longitude_decimal_degrees").text.toFloat,
      (node \ "station_latitude_dms").text,
      (node \ "station_longitude_dms").text,
      (node \ "station_altitude").text.toInt,
      (node \ "type_of_station").text,
      (node \ "station_type_of_area").text,
      (node \ "station_characteristic_of_zone").text,
      (node \ "station_subcategory_rural_background").text,
      (node \ "monitoring_obj").text, // How to divide into three separate units?
      (node \ "meteorological_parameter").text //How to divide into eleven separate units

    )
  }

  println("")
  val children = childXML.map(el => fromXML(el))
  children.foreach(println)

  case class MyFile(station_european_code: String,
                    station_local_code: String,
                    station_name: String,
                    station_description: String,
                    station_nuts_level0: String,
                    station_nuts_level1: Int,
                    station_nuts_level2: Int,
                    station_nuts_level3: Int,
                    lau_level1_code: Int,
                    lau_level2_code: Int,
                    lau_level2_name: String,
                    sabe_country_code: String,
                    sabe_unit_code: Int,
                    sabe_unit_name: String,
                    station_start_date: String,
                    station_latitude_decimal_degrees: Float,
                    station_longitude_decimal_degrees: Float,
                    station_latitude_dms: String,
                    station_longitude_dms: String,
                    station_altitude: Int,
                    type_of_station: String,
                    station_type_of_area: String,
                    station_characteristic_of_zone: String,
                    station_subcategory_rural_background: String,
                    monitoring_obj: String, meteorological_parameter: String)

//  implicit val childXML = upickle.default.macroRW[MyFile]

  def fromXMLtoFile(node: scala.xml.Node):MyFile = {
  MyFile(
    station_european_code = node.toString,
    station_local_code = node.toString,
    station_name = node.toString,
    station_description = node.toString,
    station_nuts_level0 = node.toString,
    station_nuts_level1 = node.toString.toInt,
    station_nuts_level2 = node.toString.toInt,
    station_nuts_level3 = node.toString.toInt,
    lau_level1_code = node.toString.toInt,
    lau_level2_code = node.toString.toInt,
    lau_level2_name = node.toString,
    sabe_country_code = node.toString,
    sabe_unit_code = node.toString.toInt,
    sabe_unit_name = node.toString,
    station_start_date = node.toString,
    station_latitude_decimal_degrees = node.toString.toFloat,
    station_longitude_decimal_degrees = node.toString.toFloat,
    station_latitude_dms = node.toString,
    station_longitude_dms = node.toString,
    station_altitude = node.toString.toInt,
    type_of_station = node.toString,
    station_type_of_area = node.toString,
    station_characteristic_of_zone = node.toString,
    station_subcategory_rural_background = node.toString,
    monitoring_obj = node.toString,
    meteorological_parameter = node.toString)
  }
//  val fileSeq = childXML.map(f => fromXMLtoFile(f)
//  val singleJson = upickle.default.write(fileSeq(0), indent = 4)
//  println(singleJson)
//  val filesJson = upickle.default.write(fileSeq, indent = 4)
//
//  val saveJsonPath = "./src/resources/json/StationInfo.json"
//  Utilities.saveString(filesJson, saveJsonPath)
}


