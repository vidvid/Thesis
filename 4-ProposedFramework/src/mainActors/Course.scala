‍class Course( 
  var id: String,
  var name: String,
  var units: Int,
  var preRequisites: List[Course]) extends Actor {
  def act() {
    loop {
      react {
        case  ...
      }
    }
  }