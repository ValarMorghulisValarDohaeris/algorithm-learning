package jianZhiOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 解：采用了从前往后遍历替换，这样会让后面的子字符串移动次数更多。如果从后往前的话，可以减少子字符串移动的次数。
 *
 * Created on 2018/8/5.
 * @author hao
 */
public class RepalceSpaceInString {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return str.toString();
        }

        int len = str.length();
        int index = 0;
        while(index < len){
            if(str.charAt(index) == ' '){
                str.replace(index,index+1,"%20");
                index += 3;
                len += 2;
            }else{
                index++;
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        RepalceSpaceInString repalceSpaceInString = new RepalceSpaceInString();
        String s = repalceSpaceInString.replaceSpace(new StringBuffer("We  Are      Happy"));
        System.out.println(s);
    }
}
