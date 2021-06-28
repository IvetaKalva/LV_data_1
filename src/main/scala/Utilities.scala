
object Utilities {

  def saveString(text: String, destPath: String): Unit = {
    import java.io.{File, PrintWriter} //explicit import
    //import java.io._ //this was wildcard import meaning we got all of java.io library which we might not need
    val pw = new PrintWriter(new File(destPath))
    pw.write(text)
    pw.close()
  }
}
