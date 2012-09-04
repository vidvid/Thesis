class GPAActor(
  val term: Term,
  val studyRecords: List[StudyRecord],
   val target: Actor) extends Actor {

  var processedMessages = 0
  var weightedSumOfGrades = 0
  var sumOfUnits = 0
 
  override def act() {
    for(sr <- studyRecords) 
      sr ! GPAInfoRequest(term, this, )

    loop {
      react {
        case GPAInfoResponse(isForTerm:Boolean, grade: Double, units:Int) =>
          processMessage(isForTerm, grade, units)
      }
    }
  }

  def processMessage(isForTerm:Boolean, grade:Double, units:Int) {
    if(isForTerm) {
              weightedSumOfGrades += units * grade
              sumOfUnits += sumOfUnits
    }
    processedMessages ++
    if(processedMessages == studyRecords.size) {
      target ! GPAResponse(weightedSumOfGrades / sumOfUnits)
      exit      
    }
  }
}

