<template>
  <a-row style="width: 100%;" :gutter="20">
    <a-col :span="4">
      <a-menu mode="inline" style="width: 100%;margin-top: 30px" v-if="contactList.length !== 0">
        <a-menu-item :key="index" style="height: 80px;margin: 0 auto;text-align: left;line-height: 80px" v-for="(item, index) in contactList" @click="onChange(item)">
          <span style="margin-left: 35px;font-size: 15px">
            {{ item.name }}
          </span>
        </a-menu-item>
      </a-menu>
      <div style="text-align: center;margin-top: 50px" v-else>
        <a-icon type="meh" theme="twoTone" style="font-size: 50px;"/>
        <p style="font-size: 20px;margin-top: 30px">暂无联系人</p>
      </div>
    </a-col>
    <a-col :span="20">
      <div style="background:#ECECEC; padding:30px">
        <a-card>
          <a-list
            class="comment-list"
            item-layout="horizontal"
            :data-source="chatList"
          >
            <a-list-item slot="renderItem" slot-scope="item, index">
              <a-comment :author="item.type == 1 ? item.expertName : item.enterpriseName">
                <p slot="content">
                  {{ item.content }}
                </p>
                <a-tooltip slot="datetime" :title="item.createDate">
                  <span>{{ item.createDate }}</span>
                </a-tooltip>
              </a-comment>
            </a-list-item>
          </a-list>
          <a-comment v-if="chatList.length !== 0">
            <div slot="content">
              <a-form-item>
                <a-textarea :rows="4" v-model="contentValue"/>
              </a-form-item>
              <a-form-item>
                <a-button html-type="submit" type="primary" @click="handleSubmit">
                  Add Comment
                </a-button>
              </a-form-item>
            </div>
          </a-comment>
        </a-card>
      </div>
    </a-col>
  </a-row>
</template>

<script>
import {mapState} from 'vuex'
export default {
  name: 'Chat',
  computed: {
    ...mapState({
      multipage: state => state.setting.multipage,
      user: state => state.account.user
    })
  },
  data () {
    return {
      chatList: [],
      contactList: [],
      contentValue: '',
      currentItem: null
    }
  },
  mounted () {
    this.selectContactPerson()
  },
  methods: {
    selectContactPerson () {
      this.$get(`/cos/chat-info/contact/person`, {
        userId: this.user.userId,
        flag: 2
      }).then((r) => {
        this.contactList = r.data.data
      })
    },
    onChange (item) {
      this.currentItem = item
      this.$get(`/cos/chat-info/record`, {
        expertCode: item.userCode,
        enterpriseCode: item.pharmacyCode
      }).then((r) => {
        this.chatList = r.data.data
        console.log(this.chatList)
      })
    },
    handleSubmit () {
      if (this.contentValue === '') {
        this.$message.error('请输入消息')
        return false
      }
      this.$post(`/cos/chat-info`, {
        userCode: this.currentItem.userCode,
        pharmacyCode: this.currentItem.pharmacyCode,
        type: 2,
        content: this.contentValue
      }).then((r) => {
        this.contentValue = ''
        this.onChange(this.currentItem)
      })
    }
  }
}
</script>
<style scoped>
  /deep/ .ant-list-item {
    padding: 0;
  }

  /deep/ .ant-comment-inner {
    padding: 15px 0 0 0;
  }
</style>
