<template>
  <div class="chat-container">
    <div class="chat-header">
      <h2>智能助手</h2>
    </div>
    <div class="chat-messages">
      <div v-for="message in list" :key="message.id" class="message">
        <div v-if="!message.isSelf" style="margin-left: 560px;color: grey;white-space: pre-wrap">
          {{message.createTime != null ? message.createTime + '\n' : null}}
        </div>
        <div v-else style="white-space: pre-wrap;color: grey">
          {{message.createTime != null ? message.createTime + '\n' : null}}
        </div>
        <div class="user" v-if="!message.isSelf" >
          <div class="customer-message">
            {{ message.infoContent }}
          </div>
          <div class="customer-message-img">
            <img :src="$target +'public/imgs/yonghu.jpg'" alt="" style="width: 100%; height: 100%">
          </div>
        </div>
        <div class="agent" v-else>
          <div class="agent-message-img">
            <img :src="$target +'public/imgs/chat.png'" alt="" style="width: 100%; height: 100%">
          </div>
          <div class="agent-message">{{ message.infoContent}}</div>
        </div>
      </div>
    </div>
    <div class="chat-input">
      <input type="text" v-model="text" @keyup.enter="onSend" placeholder="输入消息..." />
      <button @click="onSend">发送</button>
    </div>
    <van-image width="45px" height="45px"  round src="https://img01.yzcdn.cn/vant/cat.jpeg" />
  </div>

</template>

<script>
import { fetchEventSource } from "@microsoft/fetch-event-source";
export default {
  name: 'ChatCustomer',
  data() {
    return {
      see: '',
      text: '',
      list: [],
      gettime: ''
    }
  },
  mounted() {

  },
  created() {
    this.init()
  },
  activated() {
    // 获取消息数据
    this.$axios
      .post("/api/chatCustomerInfo/getInfoList", {
        userId: this.$store.getters.getUser.id
      })
      .then(res => {
        if (res.data.code === "001") {
          this.list = res.data.data;
        }
        this.getCurrentTime();
        let chuList = {
          isSelf: 1,
          infoContent: '您好,我是悦选市集智能助手小悦,快开始向我提问吧!',
          createTime: this.gettime
        }
        this.list.push(chuList)
      })
      .catch(err => {
        return Promise.reject(err);
      });
  },
  methods: {
    getCurrentTime() {
      //获取当前时间并打印
      let yy = new Date().getFullYear();
      let mm = new Date().getMonth() + 1;
      let dd = new Date().getDate();
      let hh = new Date().getHours();
      let mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes();
      let ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds();
      this.gettime = '                                                          ' + yy + '/' + mm + '/' + dd + ' ' + hh + ':' + mf + ':' + ss + '                                                   ' + '\n';
    },
    onSend: function () {
      let infoContent = this.text
      this.text = ''
      let newList = {
        isSelf: 0,
        infoContent: infoContent,
      }
      this.list.push(newList)
      let newList1 = {
        isSelf: 1,
        infoContent: '......'
      }
      this.list.push(newList1)
      let s = {"infoContent": infoContent,"userId": this.$store.getters.getUser.id}
      //
      fetchEventSource("/api/chatCustomerInfo/completions", {
        body: JSON.stringify(s),
        headers: {
          'Content-Type': 'application/json'
        },
        method: "POST",
        onmessage: (event) => {
          let s = JSON.parse(event.data);
          this.list.splice(this.list.length - 1,1,{isSelf: 1,infoContent: s.data})
        },
        onclose() {
        },
      });
    }
  },
}
</script>

<style>
.chat-container {
  width: 800px;
  height: 800px;
  margin: 0 auto;
  border: 1px solid #ccc;
  border-radius: 5px;
  overflow: hidden;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

}

.chat-header {
  background-color: #f2f2f2;
  padding: 10px;
  text-align: center;
  border-bottom: 1px solid #ccc;
}

.chat-messages {
  max-height: 650px;
  overflow-y: auto;
  padding: 10px;
}
.message {
  margin-bottom: 10px;
  height: 100%;
  padding: 15px 16px;
  display: flex;
  flex-direction: column;
}
.user {
  align-self: flex-end;
  display: flex;
}
.agent {
  display: flex;
}
.customer-message {
  background-color: #e6f7ff;
  padding: 20px;
  border-radius: 5px;
  width: fit-content;
  max-width: 500px; /* 聊天气泡的最大宽度 */
  word-wrap: break-word; /* 在单词边界处换行 */
  white-space: pre-wrap;
}
.customer-message-img {
  width: 60px;
  height: 60px;
  padding: 0 0 0 10px;
  border-radius: 5px;
}
.agent-message-img {
  width: 60px;
  height: 60px;
  padding: 0 10px 0 0;
  border-radius: 5px;
}

.agent-message {
  background-color: #f2f2f2;
  padding: 20px;
  border-radius: 5px;
  width: fit-content;
  max-width: 500px; /* 聊天气泡的最大宽度 */
  word-wrap: break-word; /* 在单词边界处换行 */
  white-space: pre-wrap;
}
.chat-input {
  display: flex;
  align-items: center;
  padding: 10px;
}
input {
  flex: 1;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 10px;
}

button {
  padding: 8px 15px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>
