  var weightedSumOfGrades = 0
  var sumOfUnits = 0
  ...
  ...
   case GPAInfoResponse(isForTerm:Boolean, grade: Double, units:Int)
        if(isForTerm) {
          weightedSumOfGrades += units * grade
          sumOfUnits += sumOfUnits
        }
  ...





