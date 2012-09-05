class StudentTakeCourseActor(
  var student: Student, course: Course, target: Actor) extends Actor {
    override def act() {
      student !  HasPassedRequest(this, course)
    loop {
      react {
        case HasPassedResponse(course, true) =>
          //studen has already passed the course.
        case HasPassedResponse(course, false) =>
          //student has not already passed the course
      }
    }
  }

  def sendResponse(result: Boolean, comment: String) {
    target ! TakeCourseResponse(result, comment)
//    println("sent "  + TakeCourseResponse(result, comment) + " to " + target)
    exit
  }

  override def toString = "[StudentTakeCourseActor of " + student + "]"

}