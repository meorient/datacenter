/** */
package base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meorient.common.codemaker.service.AbsCodeMakerService;
import com.meorient.common.database.redis.BaseRedisDao;

/**
 * @功能:
 * @项目名:common
 * @作者:chuxu
 * @日期:2019年3月19日上午10:26:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisDao extends AbsCodeMakerService {
	@Autowired
	@Qualifier("baseRedisDaoDef")
	private BaseRedisDao baseRedisDaoDef;
	@Autowired
	@Qualifier("baseRedisDaoQueue")
	private BaseRedisDao baseRedisDaoQueue;

	/**
	 * 根据主键或唯一键查找数据
	 * 
	 * @param TestA
	 * @return
	 * @throws Exception
	 */
	@Test
	public void testGenerateCode() throws Exception {
		String[] msg1 = { "1", "2", "3" };
		String[] msg2 = { "2", "3", "4" };
		baseRedisDaoDef.saveOrUpdate("test", msg1);
		baseRedisDaoQueue.saveOrUpdate("test", msg2);
	}
}
