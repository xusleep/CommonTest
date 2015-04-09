package test;

import java.nio.ByteBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put("0123456789".getBytes());
		System.out.println(buf.position());
		//  转为读数据模式， position设为起始位置，limit设置为上次写入的position
		buf.flip();
		System.out.println(buf.limit());
		System.out.println(buf.position());
		System.out.println(new String(buf.array()));
		buf.getLong();
		buf.get();
		System.out.println(buf.position());
		// 重新设置position，可以重复读取数据
		buf.rewind();
		System.out.println("buf.rewind(): " + buf.position());
		System.out.println("buf.rewind(): " + buf.limit());
		// 将未读数据 放到buffer的前面， position设置到未读数据的最末端，limit设置为compacity, 准备好写入，
		buf.compact();
		buf.flip();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		// 重新设置position，可以重复读取数据
		buf.rewind();
		System.out.println(buf.position());
		System.out.println(buf.limit());
	}

}
