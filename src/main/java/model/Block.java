/**
 * Copyright 2018-2019 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package model;

import util.HashUtil;

public class Block {
	private String currentHash;
	private String previousHash;
	private String data;
	private long timeStamp;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getCurrentHash() {
		return currentHash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	/**
	 * Update current hash value based on data and time stamp.
	 * 
	 * @param data
	 *            representing this block.
	 * @param previousHash
	 *            to create chain with earlier block.
	 */
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = System.currentTimeMillis();
		this.currentHash = HashUtil.createHash(data, previousHash, timeStamp);
	}

}
