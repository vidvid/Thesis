receive {
    case HasPassed(course)
        if (student has passed the course ...)
          sender ! Passed(true)
        else sender ! Passed(false)

    case HasPassedPreReqs(course)
       if(hasPassedPreReqs(course))
}

def hasPassedPreReqs(course: Course): Boolean = {
    for (pre <- course.preRequisites) {
      self ! HasPassed(pre, self) 
    }
    
    for (pre <- course.preRequisites) {
      receive {
        case Passed(course, true) =>
        //...
        case Passed(course, false) =>
          return false
      }
    }
    return true;
  }