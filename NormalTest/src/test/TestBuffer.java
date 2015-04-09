package test;

import java.nio.ByteBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put("0123456789".getBytes());
		System.out.println(buf.position());
		//  תΪ������ģʽ�� position��Ϊ��ʼλ�ã�limit����Ϊ�ϴ�д���position
		buf.flip();
		System.out.println(buf.limit());
		System.out.println(buf.position());
		System.out.println(new String(buf.array()));
		buf.getLong();
		buf.get();
		System.out.println(buf.position());
		// ��������position�������ظ���ȡ����
		buf.rewind();
		System.out.println("buf.rewind(): " + buf.position());
		System.out.println("buf.rewind(): " + buf.limit());
		// ��δ������ �ŵ�buffer��ǰ�棬 position���õ�δ�����ݵ���ĩ�ˣ�limit����Ϊcompacity, ׼����д�룬
		buf.compact();
		buf.flip();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		// ��������position�������ظ���ȡ����
		buf.rewind();
		System.out.println(buf.position());
		System.out.println(buf.limit());
	}

}
