class PongActor extends Actor {
  def act() {
    loop {
      receive {
        case Ping =>
          sender ! Pong
        case Stop =>
          Console.println("Pong: stop")
          exit()
      }
    }
  }
}