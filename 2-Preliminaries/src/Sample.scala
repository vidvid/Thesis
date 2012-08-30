class Course(var id: String, var name: String, var units: Int,
  var preRequisites: List[Course]) extends BaseDomain {
  
  override def equals(other: Any): Boolean =
    other match {
      case that: Course =>
          id == that.id
      case _ => false
    }

  def printPrerequisites() = {
    for (pre <- preRequisites)
      println(pre)
  }

  override def toString = "[id= " + id + ",name=" + name + ",units=" + units + "]"
}