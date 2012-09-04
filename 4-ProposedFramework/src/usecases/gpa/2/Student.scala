class Student(
  var id: String,
  var name: String,
  var studyRecords: List[StudyRecord]) extends Actor {

  override def act() {
    loop {
      react {
       case GPARequest(term: Term) =>
        val gpa = new GPAActor(term, studyRecords, sender)
        gpa.start
       case TakeCourseRequest(offering:Offering)=>
       ...
      }
    }
  }
}

