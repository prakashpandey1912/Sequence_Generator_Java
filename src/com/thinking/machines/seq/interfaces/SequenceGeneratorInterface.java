package com.thinking.machines.seq.interfaces;
import com.thinking.machines.seq.exceptions.*;
public interface SequenceGeneratorInterface
{
public int getNext(String entity) throws SequenceException;
}