package com.himalaya.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		// defaultConsumer.shutdown();
	}

	@Test
	public void testMongoDB() {
		try {
			// ʵ����Mongo��������27017�˿�
			Mongo mongo = new Mongo("localhost", 27017);
			// ������Ϊyourdb�����ݿ⣬�������ݿⲻ���ڵĻ���mongodb���Զ�����
			DB db = mongo.getDB("test");
			// Get collection from MongoDB, database named "yourDB"
			// ��Mongodb�л����ΪyourColleection�����ݼ��ϣ���������ݼ��ϲ����ڣ�Mongodb��Ϊ���½���
			DBCollection collection = db.getCollection("col");
			// ʹ��BasicDBObject���󴴽�һ��mongodb��document,�����踳ֵ��
			BasicDBObject document = new BasicDBObject();
			document.put("id", 1001);
			document.put("msg", "hello world mongoDB in Java");
			// ���½�����document���浽collection��ȥ
			collection.insert(document);
			// ����Ҫ��ѯ��document
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("id", 1001);
			// ʹ��collection��find��������document
			DBCursor cursor = collection.find(searchQuery);
			// ѭ��������
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
