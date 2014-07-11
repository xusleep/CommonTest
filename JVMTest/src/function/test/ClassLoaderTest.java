package function.test;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ClassLoader myLoader = new ClassLoader(){
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try
				{
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					System.out.println("fileName is " + fileName);
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null){
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				}
				catch(IOException e)
				{
					throw new ClassNotFoundException();
				}
			}
		};
		Object obj = myLoader.loadClass("function.test.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof function.test.ClassLoaderTest);
	}

}
