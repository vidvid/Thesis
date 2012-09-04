
class StudyRecord(
  var grade: Double,
  var offering: Offering)  extends Actor {
  override def act() {
    loop {
      react {
       case GPAInfoRequest(term: Term) => //comes from student
          val firstSender = sender
          offering !? GPAInfoRequest(term) match {
            case GPAInfoResponse(isForTerm,null,units)
            firstSender ! GPAInfoResponse
          }
      }
    }
  }
}