public boolean hasPassedCourse(Course course) {
  if student has passed this course 
    return true
  else 
    return false
}

public boolean hasPassedPreReqs(Course course) {
  fore(pre in course.preRequisites) {
    if(! this.hasPassedCourse(pre)) {
        return false;
    }
  return true
  }
}