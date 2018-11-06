package com.cyb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class FileUtils {
    /**
     * 浠ュ瓧鑺備负鍗曚綅璇诲彇鏂囦欢锛屽父鐢ㄤ簬璇讳簩杩涘埗鏂囦欢锛屽鍥剧墖銆佸０闊炽�佸奖鍍忕瓑鏂囦欢銆�
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("浠ュ瓧鑺備负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤涓�涓瓧鑺傦細");
            // 涓�娆¤涓�涓瓧鑺�
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("浠ュ瓧鑺備负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤澶氫釜瀛楄妭锛�");
            // 涓�娆¤澶氫釜瀛楄妭
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            // 璇诲叆澶氫釜瀛楄妭鍒板瓧鑺傛暟缁勪腑锛宐yteread涓轰竴娆¤鍏ョ殑瀛楄妭鏁�
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 浠ュ瓧绗︿负鍗曚綅璇诲彇鏂囦欢锛屽父鐢ㄤ簬璇绘枃鏈紝鏁板瓧绛夌被鍨嬬殑鏂囦欢
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("浠ュ瓧绗︿负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤涓�涓瓧鑺傦細");
            // 涓�娆¤涓�涓瓧绗�
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 瀵逛簬windows涓嬶紝\r\n杩欎袱涓瓧绗﹀湪涓�璧锋椂锛岃〃绀轰竴涓崲琛屻��
                // 浣嗗鏋滆繖涓や釜瀛楃鍒嗗紑鏄剧ず鏃讹紝浼氭崲涓ゆ琛屻��
                // 鍥犳锛屽睆钄芥帀\r锛屾垨鑰呭睆钄絓n銆傚惁鍒欙紝灏嗕細澶氬嚭寰堝绌鸿銆�
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("浠ュ瓧绗︿负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤澶氫釜瀛楄妭锛�");
            // 涓�娆¤澶氫釜瀛楃
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 璇诲叆澶氫釜瀛楃鍒板瓧绗︽暟缁勪腑锛宑harread涓轰竴娆¤鍙栧瓧绗︽暟
            while ((charread = reader.read(tempchars)) != -1) {
                // 鍚屾牱灞忚斀鎺塡r涓嶆樉绀�
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 浠ヨ涓哄崟浣嶈鍙栨枃浠讹紝甯哥敤浜庤闈㈠悜琛岀殑鏍煎紡鍖栨枃浠�
     */
    public static StringBuffer readFileByLines(String fileName) {
    	StringBuffer content = new StringBuffer("");
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
            //new FileReader(file)
            String tempString = null;
            int line = 1;
            // 涓�娆¤鍏ヤ竴琛岋紝鐩村埌璇诲叆null涓烘枃浠剁粨鏉�
            while ((tempString = reader.readLine()) != null) {
                // 鏄剧ず琛屽彿
                content.append(tempString.trim()+",");
               // line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return content;
    }

    /**
     * 闅忔満璇诲彇鏂囦欢鍐呭
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("闅忔満璇诲彇涓�娈垫枃浠跺唴瀹癸細");
            // 鎵撳紑涓�涓殢鏈鸿闂枃浠舵祦锛屾寜鍙鏂瑰紡
            randomFile = new RandomAccessFile(fileName, "r");
            // 鏂囦欢闀垮害锛屽瓧鑺傛暟
            long fileLength = randomFile.length();
            // 璇绘枃浠剁殑璧峰浣嶇疆
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 灏嗚鏂囦欢鐨勫紑濮嬩綅缃Щ鍒癰eginIndex浣嶇疆銆�
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 涓�娆¤10涓瓧鑺傦紝濡傛灉鏂囦欢鍐呭涓嶈冻10涓瓧鑺傦紝鍒欒鍓╀笅鐨勫瓧鑺傘��
            // 灏嗕竴娆¤鍙栫殑瀛楄妭鏁拌祴缁檅yteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 鏄剧ず杈撳叆娴佷腑杩樺墿鐨勫瓧鑺傛暟
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("褰撳墠瀛楄妭杈撳叆娴佷腑鐨勫瓧鑺傛暟涓�:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copyFile(String src, String dest) throws IOException {
        try {
          FileInputStream in = new FileInputStream(src);
          File file = new File(dest);
          if (!file.exists()) {
            file.createNewFile();
          }
          FileOutputStream out = new FileOutputStream(file);

          byte[] buffer = new byte[1024];
          int c;
          while ((c = in.read(buffer)) != -1)
          {
            for (int i = 0; i < c; i++)
              out.write(buffer[i]);
          }
          in.close();
          out.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
      }

      public static void copyFile(File src, String dest) throws IOException {
        try {
          FileInputStream in = new FileInputStream(src);
          File file = new File(dest);
          if (!file.exists())
            file.createNewFile();
          FileOutputStream out = new FileOutputStream(file);

          byte[] buffer = new byte[1024];
          int c;
          while ((c = in.read(buffer)) != -1)
          {
            for (int i = 0; i < c; i++)
              out.write(buffer[i]);
          }
          in.close();
          out.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
      }

      public static void copyFileByStream(InputStream src, String dest) {
        try {
          File file = new File(dest);
          if (!file.exists())
            file.createNewFile();
          FileOutputStream out = new FileOutputStream(dest);

          byte[] buffer = new byte[1024];
          int c;
          while ((c = src.read(buffer)) != -1)
          {
            for (int i = 0; i < c; i++)
              out.write(buffer[i]);
          }
          src.close();
          out.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
      }
      public static void writeString2File(String content,String dest) {
  		FileOutputStream fop = null;
  		File file;
//  		StringBuffer content = new StringBuffer("This is the text content 涓枃"+"\n");
//  		content.append("This is the text content 涓枃鏄�");
  		try {
  			file = new File(dest);
  			//濡傛灉绗簩涓弬鏁颁负true锛屽垯灏嗗瓧鑺傚啓鍏ユ枃浠舵湯灏惧锛岃�屼笉鏄啓鍏ユ枃浠跺紑濮嬪
  			fop = new FileOutputStream(file,true);
  			if (!file.exists()) {
  				file.createNewFile();
  			}
  			byte[] contentInBytes = content.toString().getBytes();
  			fop.write(contentInBytes);
  			fop.flush();
  			fop.close();
  			System.out.println("瀛楃涓插唴瀹瑰啓鍏ュ埌鏂囦欢瀹屾垚锛�");
  		} catch (IOException e) {
  			e.printStackTrace();
  		} finally {
  			try {
  				if (fop != null) {
  					fop.close();
  				}
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  		}
  	}
    public static void main(String[] args) {
        String fileName = "d:\\file\\industry.txt";
         System.out.println(FileUtils.readFileByLines(fileName));
         
         List<String> x= new ArrayList<String>();
         x.add("-");x.add("1");x.add("3s");x.add("-");
         List<String> y= new ArrayList<String>();
         y.add("1");y.add("2");y.add("3");y.add("4");
       /* FileUtils.readFileByChars(fileName);
         FileUtils.readFileByBytes(fileName);
        FileUtils.readFileByRandomAccess(fileName);*/
//         List<Integer> idx = new ArrayList<Integer>();
//         int count = 0;
//         for(int i=0;i<x.size();i++){
//        	 if(x.get(i).equals("-"))
//        	 {
//        		 count++;
//        	 }
//         }
//         int arr[] = new int[count];
//         for(int i=0;i<x.size();i++){
//        	 if(x.get(i).equals("-"))
//        	 {
//        		 arr[i] = i;
//        	 }
//         }
//         for(int i=0;i<arr.length;i++){
//        	x.remove(arr[i]);
//        	y.remove(arr[i]);
//         }
         Iterator<String> x1 = x.iterator();  
         Iterator<String> y1 = y.iterator();  
         while(x1.hasNext()&&y1.hasNext()){  
        	 String tmpx = x1.next();
             if(tmpx.equals("-")){  
                 //移除当前的对象  
                 x1.remove();  
                 y1.remove();  
             }  
         }  
         System.out.println(x+"#"+y);
    }
}