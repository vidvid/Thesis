actorB !? Msg1(value) match {
    case Response1(r) =>
      // ...
}
 
receive {
    case Msg2(value) =>
      reply(Response2(value))
}