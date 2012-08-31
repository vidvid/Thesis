object pingpong extends Application {
  val pong = new PongActor
  val ping = new PingActor(100, pong)
  ping.start
  pong.start
}