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

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BlockTest {

	@Test
	public void testBlock() {
		List<Block> blockChain = new ArrayList<Block>();
		Block block1 = new Block("Block1", "0");
		blockChain.add(block1);
		Block block2 = new Block("Block2", block1.getCurrentHash());
		blockChain.add(block2);
		Block block3 = new Block("Block3", block2.getCurrentHash());
		blockChain.add(block3);

		String previousHash = blockChain.get(0).getCurrentHash();
		for (int i = 0; i < blockChain.size(); i++) {
			Assert.assertEquals("Block" + (i + 1), blockChain.get(i).getData());
			if (i > 0) {
				Assert.assertEquals(previousHash, blockChain.get(i).getPreviousHash());
			}
			previousHash = blockChain.get(i).getCurrentHash();
		}

	}

}
