
class StudyRecord(
  var grade: Double,
  var offering: Offering)  extends Actor {
  override def act() {
    loop {
      react {
       case GPAInfoRequest(term: Term) => //comes from student
         offering ! GPAInfoRequest(term)
       case GPAInfoResponse(isForTerm, grade, units)  => //comes from offering
         who ! GPAInfoResponse(...) ????
      }
    }
  }
}