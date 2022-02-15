pipeline {
	// 执行job的机器标签
    agent {label 'master'}

    tools {
        // 在Jenkins管理菜单中配置全局工具配置里面添加的。章节4.2.2全局工具配置中配置的名称
        maven 'Maven363'
		    jdk 'JDK1.8'
    }

    stages {
		// 构建阶段步骤内容
        stage('Build') {
            steps {
                // 从GitHub克隆代码，需要先将公钥拷贝到GitHub中
                git 'git@github.com:millergo/JaCoCoTest.git'

                // 运行shell脚本命令
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }

		// 测试阶段步骤内容
        stage('Test') {
            steps {
                // 运行shell脚本命令
                sh 'mvn clean test'
            }
        }
    }
}
