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
          for(sr <- studyRecords) {
            GPAInfoResponse(isForTerm:Boolean, grade: Double, units:Int) = sr !? GPAInfoRequest(term)
              if(isForTerm) {
                weightedSumOfGrades += units * grade
                sumOfUnits += sumOfUnits
              }
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