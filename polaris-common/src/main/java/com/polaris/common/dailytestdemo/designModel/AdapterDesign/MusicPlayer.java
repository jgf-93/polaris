package com.polaris.common.dailytestdemo.designModel.AdapterDesign;

/**
 * 适配器模式
 * 意图：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * 主要解决：主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
 *
 * 何时使用： 1、系统需要使用现有的类，而此类的接口不符合系统的需要。
 * 2、想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口。
 * 3、通过接口转换，将一个类插入另一个类系中。
 * （比如老虎和飞禽，现在多了一个飞虎，在不增加实体的需求下，增加一个适配器，在里面包容一个虎对象，实现飞的接口。）
 */
public class MusicPlayer implements Player {
    private PlayerAdapter playerAdapter;

    @Override
    public void play(String playName) {
        if ("MUSIC".equalsIgnoreCase(playName)) {
            System.out.println("播放了" + playName + "............");
        } else if ("VLC".equalsIgnoreCase(playName) || "MP4".equalsIgnoreCase(playName)) {
            playerAdapter = new PlayerAdapter(playName);
            playerAdapter.play(playName);
        }
    }

    public static void main(String[] args) {
        Player player = new MusicPlayer();
        player.play("MP4");
        player.play("VLC");
        player.play("MUSIC");
    }
}
