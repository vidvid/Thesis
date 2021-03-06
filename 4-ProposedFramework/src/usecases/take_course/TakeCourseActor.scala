class StudentTakeCourseActor(
  val student: Student, course: Course, target: Actor) extends Actor {
  var receivedResponses:Int = 0
    override def act() {
      student ! PassedRequest(course)
      student ! TakenRequest(course)
      student ! PassedPresRequest(course)
    loop {  react {
        case PassedPresResponse(result) =>
          if(!result)
            sendResponse(false, "Student has not passed prerequisites")
          else waitForNextMessage()
        case PassedResponse(result) =>
          if(result)
            sendResponse(false, "Student has already passed this course")
          else waitForNextMessage()
        case TakenResponse(result) =>
          if(result)
            sendResponse(false, "Student has already taken this course")
          else waitForNextMessage()
      } }
  }
  def sendResponse(result: Boolean, comment: String) {
    target ! TakeCourseResponse(result, comment)
    exit
  }
  def waitForNextMessage() {
    receivedResponses++
    if(receivedResponses == 3) {
      //save a StudyRecord for course
      sendResponse(true, "successful")
    }
  }
}