package com.example.test.test;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.example.test.Tests;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import junit.framework.TestCase;

public class Test extends TestCase {

	public static void test() throws NoSuchAlgorithmException, IOException {
		File image = new File("/storage/sdcard/nNlmKXiQDBSyTdngEQKORlRVAJ.png");
		String hash1 = Tests.getBitmapHash(image);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inDither = false;
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),options);
		String hash2 = Tests.getBitmapHash(bitmap);
		String actualHash = "ac0aea39509f917380b5178c0f5a2f7a";
		Log.i("yo!", "first hash : " + hash1);
		Log.i("yo!", "second hash : " + hash2);
		assertTrue("First hash wrong", actualHash.equals(hash1));
		assertTrue("SEcond hash wrong", actualHash.equals(hash2));
	}
}
