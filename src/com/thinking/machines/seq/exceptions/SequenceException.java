package com.thinking.machines.seq.exceptions;
import java.io.*;
public class SequenceException extends Exception implements Serializable
{
public SequenceException(String message)
{
super(message);
}
}