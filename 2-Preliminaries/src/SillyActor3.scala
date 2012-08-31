object SillyActor extends Actor {
  def act() {
  	loop {
  		for (i <- 1 to 5) {
      		println("I'm acting!")
      		Thread.sleep(1000)
    	}	
  	}
  }
}