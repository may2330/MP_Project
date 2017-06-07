package com.integratedideas.speechandaudio;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 미디 파일을 생성해내기 위한 클래스
 *
 * @author hyeongkyu
 *
 */
public class MidiFileCreator {
	private Context mCtx;

	//index:100, 104번이 음계, 0x3C=가온다
	//index:89번이 패치 번호, 0x01=standard grand piano, 0x21=electric bass guitar(finger)
	private final int[] DUMMY_BYTES = new int[]{
			0x4d, 0x54, 0x68, 0x64, 0x00, 0x00, 0x00, 0x06, 0x00, 0x01, 0x00, 0x02, 0x00, 0xc0, 0x4d, 0x54,
			0x72, 0x6b, 0x00, 0x00, 0x00, 0x2e, 0x00, 0xff, 0x03, 0x02, 0x61, 0x31, 0x00, 0xff, 0x01, 0x20,
			0x47, 0x65, 0x6e, 0x65, 0x72, 0x61, 0x74, 0x65, 0x64, 0x20, 0x62, 0x79, 0x20, 0x4e, 0x6f, 0x74,
			0x65, 0x57, 0x6f, 0x72, 0x74, 0x68, 0x79, 0x20, 0x43, 0x6f, 0x6d, 0x70, 0x6f, 0x73, 0x65, 0x72,
			0x00, 0xff, 0x2f, 0x00, 0x4d, 0x54, 0x72, 0x6b, 0x00, 0x00, 0x00, 0x22, 0x00, 0xff, 0x21, 0x01,
			0x00, 0x00, 0xff, 0x03, 0x02, 0x61, 0x31, 0x00, 0xc4, 0x01, 0x00, 0xb4, 0x07, 0x7f, 0x00, 0xb4,
			0x0a, 0x40, 0x00, 0x94, 0x39, 0x6e, 0x5e, 0x94, 0x39, 0x00, 0x00, 0xff, 0x2f, 0x00
	};

	public MidiFileCreator(Context mCtx) {
		super();
		this.mCtx = mCtx;
	}

	/**
	 * 음계별 미디 파일을 생성합니다.
	 *
	 * @param patch 악기 패치 번호
	 * @param octaveShift 옥타브 시프트 (이 기능은 아직 구현되지 않았으며, 추후에도 구현될 것 같지 않다)
	 * @throws IOException
	 */
	public void createMidiFiles(int patch, int octaveShift) throws IOException{

		int pitch = 0x3c-36+(octaveShift*12);

		int[] bytes = DUMMY_BYTES;
		String[] pitches = SearchActivity.PITCHES;

		String dir = mCtx.getDir("", Context.MODE_PRIVATE).getAbsolutePath();

		for(int i=1;i<=SearchActivity.OCTAVE_COUNT;i++){
			for (int j=0;j<pitches.length;j++){
				File file = new File(dir+ File.separator+pitches[j]+i+".mid");
				if(!file.exists())file.createNewFile();
				FileOutputStream fos = new FileOutputStream(file);
				bytes[100] = pitch;
				bytes[104] = pitch;
				bytes[89] = patch;

				for(int c=0;c<bytes.length;c++) fos.write(bytes[c]);
				fos.close();

				pitch++;
			}
		}
	}
}