class StudyRecord(
  var grade: Double,
  var offering: Offering) extends Actor {
  def act() {
    loop {
      react {
        case  ...
      }
    }
  }