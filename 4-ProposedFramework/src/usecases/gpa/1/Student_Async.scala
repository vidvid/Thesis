class Student(
  var id: String,
  var name: String,
  var studyRecords: List[StudyRecord]) extends Actor {

  var weightedSumOfGrades = 0
  var sumOfUnits=0
 
  override def act() {
    loop {
      react {
       case GPARequest(term: Term) =>{
          val replies = for(sr <- studyRecords) yield {sr !! GPAInfoRequest(term)}
          for(i <- 0 until offerings.size) {
            GPAInfoResponse(isForTerm:Boolean, grade: Double, units:Int) = replies(i)
            if(isForTerm) {
              weightedSumOfGrades += units * grade
              sumOfUnits += sumOfUnits
            }
          }
          sender ! GPAResponse(weightedSumOfGrades / sumOfUnits)
       }
       case TakeCourseRequest(offering:Offering)=>
       ...
      }
    }
  }
}

