actorA !? Msg2(value) match {
    case Response2(r) =>
      // ...
}
 
receive {
    case Msg1(value) =>
      reply(Response1(value))
}