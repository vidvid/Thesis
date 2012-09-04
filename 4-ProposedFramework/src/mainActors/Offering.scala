class Offering( 
  var id: String,
  var examDate: Date,
  var course: Course,
  var term: Term) extends Actor {
  def act() {
    loop {
      react {
        case  ...
      }
    }
  }