class Offering(
  var id: String,
  var course: Course,
  var examDate: Date,
  var term: Term)  extends Actor {
  override def act() {
    loop {
      react {
       case GPAInfoRequest(gpaTerm: Term) =>
         val termFuture = term !! IsYourTermRequest(gpaTerm)
         val courseFuture = course !! NumOfUnitsRequest
         sender ! GPAInfoResponse(termFuture(),null,courseFuture())
         }
      }
    }
  }
}