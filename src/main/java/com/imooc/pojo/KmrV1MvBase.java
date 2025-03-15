package com.imooc.pojo;

public class KmrV1MvBase {

	// is_xxx值 1是 0否
	public static final int IS_YES = 1;
	public static final int IS_NO = 0;

	private long video_id;

	private String album_audio_id;

	private String singer;

	private String mv_name;

	private long duration;

	private int is_publish;

	public long getVideo_id() {
		return video_id;
	}

	public void setVideo_id(long video_id) {
		this.video_id = video_id;
	}

	public String getAlbum_audio_id() {
		return album_audio_id;
	}

	public void setAlbum_audio_id(String album_audio_id) {
		this.album_audio_id = album_audio_id;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getMv_name() {
		return mv_name;
	}

	public void setMv_name(String mv_name) {
		this.mv_name = mv_name;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getIs_publish() {
		return is_publish;
	}

	public void setIs_publish(int is_publish) {
		this.is_publish = is_publish;
	}

	@Override
	public String toString() {
		return "KmrV1MvBase [video_id=" + video_id + ", album_audio_id=" + album_audio_id + ", singer=" + singer + ", mv_name=" + mv_name + ", duration=" + duration + ", is_publish=" + is_publish
				+ "]";
	}

}
