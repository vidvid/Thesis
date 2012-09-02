class Student(
  var id: String,
  var name: String,
  var studyRecords: List[StudyRecord]) extends Actor {
 
  override def act() {
    loop {
      react {
       case HasPassed(course, target) =>
          ...
       case HasTaken(course, target) =>
          ...
       case GPARequest(term: Term, target: Actor) =>
          ...          
       case TakeCourse(offering, target) =>
      }
    }
  }
}