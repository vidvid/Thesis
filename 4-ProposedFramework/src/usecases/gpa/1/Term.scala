class Term(
  var name: String,
  var startDate: Date,
  var offerings: List[Offering])  extends Actor {
  override def act() {
    loop {
      react {
       case IsYourTermRequest(gpaTerm) =>
         sender ! (gpaTerm.name == name)
      }
    }
  }
}