

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class SentenceStack {

	
	//public Stack<StackElement> stack = new Stack<StackElement>();
	//public Stack<StackElement> reverseStack = new Stack<StackElement>();
	
	public Deque<StackElement> stack = new ArrayDeque<StackElement>();

	public Deque<StackElement> reverseStack = new ArrayDeque<StackElement>();

	public Deque<JSONString> jsonStack = new ArrayDeque<JSONString>();
	
	public void pushStack(StackElement element)
	{
		stack.push(element);
	}

	
	//we need to put the stack elements onto the stack
	
	public void pushStackElementArray(StackElement [] elements)
	{
		for (StackElement element: elements)
		{
			stack.push(element);
		}
	}
	
	//push an array list of stackelements onto the stack
	
	public void pushStackElementArrayList(ArrayList<StackElement> elements)
	{
		for (StackElement element: elements)
		{
			stack.push(element);
		}
		
	}
	
	
	//This function pushes a single stack element to the stack 
	
	public void pushStackElementArray(StackElement elements)
	{
			
			stack.push(elements);
	}
	
	public StackElement popStack()
	{
		if (!stack.isEmpty())			
			return stack.pop();
		else
			return null;
	}
	
	public StackElement popQuotedString()
	{
		return null;
	}
	
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}


	public StackElement reverseStackPop() {
		return reverseStack.pop();
	}

	public void reverseStackPush(StackElement element) {
		reverseStack.push(element);
	}



}

