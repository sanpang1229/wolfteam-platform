package com.box.tei.thread;


import java.util.concurrent.Callable;

import com.wolfteam.dto.InstructionObject;
import com.wolfteam.service.process.Processor;



public class ResponseCallable implements Callable<InstructionObject> {
	
	private InstructionObject io;
	private Processor<InstructionObject> process;
	private long startTimeStamp;

	public ResponseCallable(InstructionObject io,Processor<InstructionObject> process,	long startTimeStamp) {
		super();
		this.io = io;
		this.process = process;
		this.startTimeStamp = startTimeStamp;
	}

	public InstructionObject call() throws Exception {
		process.process(io, startTimeStamp);
		
		return io;
	}
	

}
