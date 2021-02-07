
function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}

var otvetApi = Vue.resource('/otvet{/id}');

Vue.component('otvet-form', {
    props: ['otvets', 'otvetAttr'],
    data: function() {
        return {
            rayon: '',
            aged: '',
            pol: '',
            vopros_4: '',
            vopros_5: '',
            vopros_6: '',
            dt_otvet: '',
            ip: '',
            id: ''
        }
    },
    watch: {
        otvetAttr: function(newVal, oldVal) {
            this.rayon = newVal.rayon
            this.aged = newVal.aged;
            this.pol = newVal.pol;
            this.vopros_4 = newVal.vopros_4;
            this.vopros_5 = newVal.vopros_5;
            this.vopros_6 = newVal.vopros_6;
            this.dt_otvet = newVal.dt_otvet;
            this.ip = newVal.ip;
            this.id = newVal.id;
        }
    },
    template:
        '<template>' +
           '<v-layout row>' +
             '<v-text-field label="Район" filled v-model="rayon" />' +
             '<v-text-field label="Возраст" filled v-model="aged" />' +
             '<v-text-field label="Пол" filled v-model="pol" />' +
             '<v-text-field label="Вопрос_1" filled v-model="vopros_4" />' +
             '<v-text-field label="Вопрос_2" filled v-model="vopros_5" />' +
             '<v-text-field label="Вопрос_3" filled v-model="vopros_6" />' +
             '<v-text-field label="Дата ответа" filled v-model="dt_otvet" />' +
             '<v-text-field label="IP" filled v-model="ip" />' +
             '<v-btn @click="save" >Сохранить</v-btn>' +
           '</v-layout row>' +
        '</template>',
    methods: {
        save: function() {
            var rayon = { rayon: this.rayon };
            var otvet = { aged: this.aged };
            var pol = { pol: this.pol };
            var vopros_4 = { vopros_4: this.vopros_4 };
            var vopros_5 = { vopros_5: this.vopros_5 };
            var vopros_6 = { vopros_6: this.vopros_6 };
            var dt_otvet = { dt_otvet: this.dt_otvet };
            var ip = { ip: this.ip };

            if (this.id) {
                otvetApi.update({id: this.id}, otvet).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.otvets, data.id);
                        this.otvets.splice(index, 1, data);
                        this.rayon = ''
                        this.aged = ''
                        this.pol = ''
                        this.vopros_4 = ''
                        this.vopros_5 = ''
                        this.vopros_6 = ''
                        this.dt_otvet = ''
                        this.ip = ''
                        this.id = ''
                    })
                )
            } else {
                otvetApi.save({}, otvet).then(result =>
                    result.json().then(data => {
                        this.otvets.push(data);
                        this.rayon = ''
                        this.aged = ''
                        this.pol = ''
                        this.vopros_4 = ''
                        this.vopros_5 = ''
                        this.vopros_6 = ''
                        this.dt_otvet = ''
                        this.ip = ''
                    })
                )
            }
        }
    }
});

Vue.component('otvet-row', {
    props: ['otvet', 'editMethod', 'otvets'],
    template: '<template>' +
                 '<v-card class="my-3">'+
                 ' <v-card-text primary-title>'+
          '<i>({{ otvet.id }})</i> {{ otvet.aged }} '+
                                 '{{ otvet.rayon }} '+
                                 '{{ otvet.pol }} '+
                                 '{{ otvet.vopros_4 }} '+
                                 '{{ otvet.vopros_5 }} '+
                                 '{{ otvet.vopros_6 }} '+
                                 '{{ otvet.dt_otvet }} '+
                                 '{{ otvet.ip }}' +
                 ' </v-card-text>'+
        '<v-card-actions>' +
//                  '<v-btn value="Edit" @click="edit" small flat round>Edit</v-btn>'+
//                  '<vc-btn value="Delet" @click="del" small> Удалить  </v-btn>'+
        '</v-card-actions>' +
        '</v-card>'+
        '</template>',
    methods: {
        edit: function() {
            this.editMethod(this.otvet);
        },
        del: function() {
            otvetApi.remove({id: this.otvet.id}).then(result => {
                if (result.ok) {
                    this.otvets.splice(this.otvets.indexOf(this.otvet), 1)
                }
            })
        }
    }
});

Vue.component('otvets-list', {
  props: ['otvets'],
  data: function() {
    return {
        otvet: null
    }
  },
  template:
    '<template>' +
       '<v-layout align-space-around justify-start column>'+
        '<otvet-form :otvets="otvets" :otvetAttr="otvet" />' +
        '<otvet-row v-for="otvet in otvets" :key="otvet.id" :otvet="otvet" ' +
            ':editMethod="editMethod" :otvets="otvets" />' +
       '</v-layout>'+
    '</template>',
  created: function() {
    otvetApi.get().then(result =>
        result.json().then(data =>
            data.forEach(otvet => this.otvets.push(otvet))
        )
    )
  },
  methods: {
    editMethod: function(otvet) {
        this.otvet = otvet;
    }
  }
});

//Vue.component('rayon-select', {
//  props: ['otvets'],
//  data: function() {
//    return {
//        otvet: null
//    }
//  },
//    template: '<template>' +
//                '<v-layout align-space-around justify-start column>'+
//                      '<v-select :items="items" filled'+
//                         '  label="Filled style"></v-select>'+
//                      '<otvet-form :otvets="otvets" :otvetAttr="otvet" />' +
//                      '<otvet-row v-for="otvet in otvets" :key="otvet.id" :otvet="otvet" ' +
//                          ':editMethod="editMethod" :otvets="otvets" />' +
//                     '</v-layout>'+
//                  '</template>'
//                   });
//<script>
//  export default {
//    data: () => ({
//      items: ['Foo', 'Bar', 'Fizz', 'Buzz'],
//    }),
//  }
//</script>
//'<template>'+
//                 '<v-container fluid>'+
//                    '<v-row align="center">'+
//                       '<v-col class="d-flex" cols="12" sm="6">'+
//                         '<v-select>'+
//                           '<option>ddd</option>'+
//                         '</v-select>'+
//                         '</v-col>'+
//                       '</v-row>'+
//                     '</v-container>'+
//                   '</template>'


var app = new Vue({
  el: '#app',
//  template: '<rayon-select :otvets="otvets" />',
  template: '<otvets-list :otvets="otvets" />',
  data: {
    otvets: []
  }
});