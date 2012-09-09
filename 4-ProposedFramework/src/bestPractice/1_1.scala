react {
	case  Message(x)
	sender ! x+1
}  