react {
	case  Message(x, target)
	target ! x+1
}