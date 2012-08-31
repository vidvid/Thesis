class PingActor(count: int, pong: Actor) extends Actor {
  def act() {
    var pingsLeft = count - 1
    pong ! Ping
    loop {
      receive {
        case Pong =>
           if (pingsLeft > 0) {
            pong ! Ping
            pingsLeft -= 1
          } else {
            pong ! Stop
            exit()
          }
      }
    }
  }
}
